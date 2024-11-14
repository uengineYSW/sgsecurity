# 

## Model
www.msaez.io/#/storming/sg20g01-ysw

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- carmng


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- carmng
```
 http :8088/vehicles carrierNo="carrierNo" worksCode="worksCode" companyCode="companyCode" carType="carType" carModel="carModel" usage="usage" fuelFlag="fuelFlag" partCompanyCd="partCompanyCd" ownerTypeCode="ownerTypeCode" assetNumber="assetNumber" organizationName="organizationName" acquisitionAmt="acquisitionAmt" driverEmpNo="driverEmpNo" userName="userName" registDate="registDate" reversalDate="reversalDate" managementNumber="managementNumber" type="type" yearTp="yearTp" mdOutputValue="mdOutputValue" lcaHeight="lcaHeight" quantity="quantity" personCount="personCount" standardValue="standardValue" maxCapacity="maxCapacity" shortDistance="shortDistance" laneDistance="laneDistance" loadedTravelDistance="loadedTravelDistance" inspectionDate="inspectionDate" description="description" weight40Max="weight40Max" width40Max="width40Max" lengthConstraintKan="lengthConstraintKan" usedWeight="usedWeight" driverId="driverId" 
 http :8088/drivers driverEmpNo="driverEmpNo" name="name" companyCode="companyCode" worksCode="worksCode" hrAccessLevel="hrAccessLevel" supervisorType="supervisorType" currentJob="currentJob" handPhone="handPhone" licenseNumber="licenseNumber" nationalIdentifier="nationalIdentifier" resourceId="resourceId" carType="carType" retirementFlag="retirementFlag" retiredDate="retiredDate" description="description" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

