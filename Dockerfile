FROM java:8

RUN mkdir /service
WORKDIR /service
ADD run /service/run
COPY configs/* /service/configs/
ADD target/helloworld-1.0-SNAPSHOT.jar /service/service.jar

ENTRYPOINT [ "./run" ]
CMD [ "default" ]

