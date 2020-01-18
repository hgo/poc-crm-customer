# poc-crm-customer

# initial
`mvn clean install`

## build image
`docker image build -t poc-customer .`


## run container
`docker container run -d -p 8080:8080 poc-customer`