# Reference application - OCI SDK for Java, config file, VCN creation
This is a minimalistic Java application used to demonstrate a very simple use of **OCI SDK for Java**. The application was written as a sample to my article in Java Magazine titled "First steps with Oracle Cloud Infrastructure SDK for Java".

### Application
The application invokes `CreateVCN` OCI API to create a new Virtual Cloud Network (VCN) in Oracle Cloud Infrastructure (OCI). The VCN will be created in Compartment which OCID we provided as an argument to the program:

```bash
java -jar target/FirstStepsSDK-1.0-jar-with-dependencies.jar $COMPARTMENT_OCID
```

### Structure
```
├── pom.xml
├── src
│   └── main
│       └── java
│           └── io
│               └── github
│                   └── mtjakobczyk
│                       └── javamagazine
│                           └── FirstStepsSDK.java
```

