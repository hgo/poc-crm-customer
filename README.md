# poc-crm-customer

# initial
`mvn clean install`

## build image
`docker image build -t poc-customer .`


## run container
`docker container run --env DB_URL=jdbc:postgresql://pocpostgres.ctbgumrcydw1.us-east-1.rds.amazonaws.com:5432/postgres --env DB_USER=postgres --env DB_PASS=poc12345 -d -p 8080:8080 poc-customer`