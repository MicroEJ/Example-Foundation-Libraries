/*
 * Copyright 2025 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.microai;

import ej.microai.InputTensor;
import ej.microai.MLInferenceEngine;
import ej.microai.OutputTensor;
import ej.microai.Tensor;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * The entry point of the MicroAI MNIST LSTM model demo.
 */
public class MnistLstm {
    private static final Logger LOGGER = Logger.getLogger("[MicroAI MNIST LSTM Sample]");
    private static final String MNIST_LSTM_MODEL_PATH = "/model/trained_lstm_int8.tflite";

    public static void main(String[] args) {
        LOGGER.info("MicroAI Sample on MNIST LSTM model");

        // Create the inference engine from the model stored in application resources.
        MLInferenceEngine model = new MLInferenceEngine(MNIST_LSTM_MODEL_PATH);

        // Get input/output tensors from the inference engine.
        InputTensor inputTensor = model.getInputTensor(0);
        OutputTensor outputTensor = model.getOutputTensor(0);

        LOGGER.info("===================================");
        LOGGER.info("Run inferences on MNIST LSTM model:");
        LOGGER.info("===================================");

        for (int label = 0; label < 10; label++) {
            String imagePath = "/samples/sample" + label + ".bmp";
            byte[] inputData;
            try {
                RawBmpReader bmpImage = new RawBmpReader(imagePath);
                inputData = bmpImage.getPixelData();
                bmpImage.printPixelData();
            } catch (IOException e) {
                LOGGER.severe("Could not load image " + imagePath + " with exception: " + e);
                break;
            }

            // Quantize input data
            Tensor.QuantizationParameters inputParameters = inputTensor.getQuantizationParams();
            for (int i = 0; i < inputTensor.getNumberElements(); i++) {
                inputData[i] = (byte)(inputData[i] + inputParameters.getZeroPoint());
            }

            // set input data
            inputTensor.setInputData(inputData);

            // run inference
            model.run();

            // get output data
            byte[] outputData = new byte[outputTensor.getNumberElements()];
            outputTensor.getOutputData(outputData);

            // Dequantize output data
            float[] predictions = new float[outputTensor.getNumberElements()];
            Tensor.QuantizationParameters outputParameters = outputTensor.getQuantizationParams();
            for (int i = 0; i < outputTensor.getNumberElements(); i++) {
                predictions[i] = (outputParameters.getScale() * (outputData[i] - outputParameters.getZeroPoint()));
            }
            // Get max value of output tensor
            float maxConfidence = 0;
            int maxIndex = 0;
            for (int i = 0; i < predictions.length; i++) {
                if (predictions[i] > maxConfidence) {
                    maxConfidence = predictions[i];
                    maxIndex = i;
                }
            }
            int confidencePerCent = (int)(maxConfidence * 100);
            LOGGER.info("image: " + label + " -> prediction: " + maxIndex + " with confidence: " + confidencePerCent + "%");

            // LSTM is stateful, reset the state after the usage since each image is independent
            model.reset();
        }
        model.close();
    }
}
