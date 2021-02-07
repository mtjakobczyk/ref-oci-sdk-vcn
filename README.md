# Reference application - OCI SDK for Java, config file, VCN creation
This is a minimalistic Java application used to demonstrate a very simple use of **OCI SDK for Java**. The application was written as a sample to my article in Java Magazine titled "First steps with Oracle Cloud Infrastructure SDK for Java".

### Application
To run this sample, you need to:
- know the compartment OCID, in which your OCI IDCS/IAM user is allowed to create VCNs (meaning: to call `CreateVcn` API)
- properly configure the `DEFAULT` profile in the `~/.oci/config` file (including a path to an active API private key)

The application invokes `CreateVCN` OCI API to create a new Virtual Cloud Network (VCN) in Oracle Cloud Infrastructure (OCI). The VCN will be created in Compartment which OCID we provided as an argument to the program:

```bash
java -jar target/FirstStepsSDK-1.0-jar-with-dependencies.jar $COMPARTMENT_OCID
```

As output, you will see an OCID of the newly created VCN. It will look similar to:
```bash
ocid1.vcn.oc1.eu-frankfurt-1.anaaaaaa7zaq6mabukz7yez3osczgvijeh3rqoyejommleenufoibvkq21dq
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

You should be able to build the sample as follows:
```bash
mvn clean package
```

### Cleanup
Do not forget to remove the sample VCN. You can do it in OCI Console or using CLI like this:
```bash
oci network vcn delete --vcn-id $VCN_OCID
```
