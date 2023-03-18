package com.ipap.grpc.service;

import com.ipap.grpc.GreetingRequest;
import com.ipap.grpc.GreetingResponse;
import com.ipap.grpc.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.logging.Level;
import java.util.logging.Logger;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    Logger logger = Logger.getLogger(GreetingServiceImpl.class.getName());

    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        //super.greeting(request, responseObserver);
        String message = request.getMessage();
        logger.log(Level.INFO, message);

        GreetingResponse greetingResponse = GreetingResponse.newBuilder()
                .setMessage("Hello from Server: " + message)
                .build();
        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();
    }
}
