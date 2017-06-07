# hello-dropwizard

This is just a sample dropwizard application to run and mess around with


## Endpoints

{root}/hello-world/v1
{root}/hello-world/v1/name
{root}/hello-world/v1/hello

## Getting started locally

1. run `mvn install`
2. run `./run`
3. Hit endpoints with whatever you want:
  * `curl http://localhost:8080/hello-world/v1`
  * `siege http://localhost:8080/hello-world/name`

## Getting started with Habitat

1. Install habitat
2. run `hab studio enter`
3. Within the studio run `build`
4. Within the studio run `hab pkg export docker brentm5/hello-dropwizard`
5. Open another terminal shell and run `docker run -P brentm5/hello-dropwizard`
6. Its up and running via habitat and docker
