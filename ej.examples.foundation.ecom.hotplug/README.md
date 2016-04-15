This example shows how to listen on plug/unplug of dynamic ComConnections and shows their properties.

#Run on the board#
1. Right Click on `ExampleHotPlug`
2. Select Run as -> Run Configuration 
3. Click on new launch configuration
4. Select Execute on EmbJPF
5. Select Build & Deploy
6. Go to Execution tab
7. Select your jpf 
8. Go to Configuration tab
9. Go to Target  -> Deploy -> Means
10. Put No deployment
11. Go to Libraries -> ECOM
12. check enable registration event notification
11. Go to Libraries -> ECOM -> Comm Connection
12. Check Enable comm connections
12. Check Enable dynamic comm ports registration
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

