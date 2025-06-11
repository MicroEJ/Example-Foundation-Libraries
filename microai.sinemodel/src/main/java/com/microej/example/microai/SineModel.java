/*
 * Copyright 2025 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.microai;

import ej.microai.InputTensor;
import ej.microai.MLInferenceEngine;
import ej.microai.OutputTensor;
import ej.microai.Tensor;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * The entry point of the MicroAI Sine model demo.
 */
public class SineModel {
    private static final Logger LOGGER = Logger.getLogger("[MicroAI Sine Sample]");
    private static final String SINE_MODEL = "/model/sine_model_float.tflite";
    private static final float PI = (float) Math.PI;
    private static final float[] INPUT_DATA = new float[] {0, PI/4, PI/2, 3*PI/4, PI, 5*PI/4, 3*PI/2, 7*PI/4, 2*PI};
    private static final String[] INPUT_DATA_STRINGS = new String[] {"0", "PI/4", "PI/2", "3*PI/4", "PI", "5*PI/4", "3*PI/2", "7*PI/4", "2*PI"};


    private static MLInferenceEngine model;
    private static InputTensor inputTensor;
    private static OutputTensor outputTensor;

    public static void main(String[] args) {
        LOGGER.info("MicroAI Sample on Sine model");

        // Create the inference engine from the model stored in application resources.
        model = new MLInferenceEngine(SINE_MODEL);

        // Get input/output tensors from the inference engine.
        inputTensor = model.getInputTensor(0);
        outputTensor = model.getOutputTensor(0);

        // Create arrays to send/receive data from the inference engine.
        float[] inputData = new float[inputTensor.getNumberElements()];
        float[] outputData = new float[outputTensor.getNumberElements()];

        // Print model description for demo purpose
        getModelCharacteristics();

        LOGGER.info("============================");
        LOGGER.info("Run inferences on sine model:");
        LOGGER.info("============================");

        for(int i = 0; i < INPUT_DATA.length; i++) {
            // Store input data and set it in the tensor.
            inputData[0] = INPUT_DATA[i];
            inputTensor.setInputData(inputData);

            // Run an inference.
            model.run();

            // Get output data from the tensor.
            outputTensor.getOutputData(outputData);
            LOGGER.info("sinus(" + INPUT_DATA_STRINGS[i] + ") = " + outputData[0]);
        }
    }

    private static void getModelCharacteristics() {
        /* Get input tensor data */
        LOGGER.info("Input:");
        LOGGER.info("    Tensor Count: " + model.getInputTensorCount());
        int inputDimensions = inputTensor.getNumberDimensions();
        LOGGER.info("    Tensor Dimensions: " + inputDimensions);
        int[] inputSizes = new int[inputDimensions];
        inputTensor.getShape(inputSizes);
        LOGGER.info("    Tensor Shape: " + Arrays.toString(inputSizes));

        LOGGER.info("    Data Type: " + inputTensor.getDataType());
        LOGGER.info("    Tensor Elements: " + inputTensor.getNumberElements());
        LOGGER.info("    data length: " + inputTensor.getNumberBytes());
        LOGGER.info("     quantized: " + inputTensor.isQuantized());
        Tensor.QuantizationParameters inputParameters = inputTensor.getQuantizationParams();
        LOGGER.info("        Scale: " + inputParameters.getScale());
        LOGGER.info("        Zero : " + inputParameters.getZeroPoint());

        /* Get output tensor data */
        LOGGER.info("Output:");
        LOGGER.info("    Tensor Count: " + model.getOutputTensorCount());
        int outputDimensions = outputTensor.getNumberDimensions();
        LOGGER.info("    Tensor Dimensions: " + outputDimensions);
        int[] outputSizes = new int[outputDimensions];
        outputTensor.getShape(outputSizes);
        LOGGER.info("    Tensor Shape: " + Arrays.toString(outputSizes));

        LOGGER.info("    Data Type: " + outputTensor.getDataType());
        LOGGER.info("    Tensor Elements: " + outputTensor.getNumberElements());
        LOGGER.info("    data length: " + outputTensor.getNumberBytes());
        LOGGER.info("    quantized: " + outputTensor.isQuantized());
        Tensor.QuantizationParameters outputParameters = outputTensor.getQuantizationParams();
        LOGGER.info("        Scale: " + outputParameters.getScale());
        LOGGER.info("        Zero : " + outputParameters.getZeroPoint());
    }
}
