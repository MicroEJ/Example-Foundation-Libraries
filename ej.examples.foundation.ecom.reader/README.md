This example shows how to read some bytes from a CommConnection.

#Run on the Simulator#
1. Right Click on ExampleUARTReader
2. Select Run as -> Run Configuration 
3. Click on new launch configuration
4. Go to Execution tab
5. Select your jpf 
6. Go to Configuration tab
7. Go to Libraries -> ECOM -> Comm Connection
8. Check Enable comm connections
9. Map the UART com port (available on your platform documentation) to the application port "42"
10. Go to Simulator -> Com Port
11. Select simulation type UART <-> FILE
12. for the File input mapping choose ${project_loc:ej.examples.foundation.ecom.reader}/src/main/resources/sim/filein.txt
13. for the File output mapping choose ${project_loc:ej.examples.foundation.ecom.reader}/src/main/resources/sim/fileout.txt
14. Press Apply
15. Press Run

#Run on the board#
1. Right Click on ExampleUARTReader
2. Select Run as -> Run Configuration 
3. Click on new launch configuration
4. Select Execute on EmbJPF
5. Select Build & Deploy
6. Go to Execution tab
7. Select your jpf 
8. Go to Configuration tab
9. Go to Target  -> Deploy -> Means
10. Put No deployment
11. Go to Libraries -> ECOM -> Comm Connection
12. Check Enable comm connections
13. Map the UART com port (available on your platform documentation) to the application port "42"
15. Press Apply
16. Press Run
17. Select Run -> Run Configuration
18. Select MicroEJ Tool
19. Click on new launch configuration
20. Select your jpf 
21. Select program with St link
22. Go to Configuration tab
23. Put the path to the generated .out file
24. Press Apply
25. Press Run

