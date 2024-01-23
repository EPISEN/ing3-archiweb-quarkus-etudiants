package fr.upec.episen;

import fr.upec.episen.proto.EtudiantGrpc;
import fr.upec.episen.proto.EtudiantNameReply;
import fr.upec.episen.proto.EtudiantNameRequest;
import io.grpc.stub.StreamObserver;

import io.quarkus.grpc.GrpcService;
import jakarta.inject.Singleton;


@GrpcService
public class EtudiantGrpcService extends EtudiantGrpc.EtudiantImplBase {

    @Override
    public void getEtudiantName(EtudiantNameRequest request, StreamObserver<EtudiantNameReply> responseObserver) {
        String ine = request.getIne();
        String nom = "";

        switch (ine){
            case "u21815645":
                nom = "Fabrice";
                break;
            case "1234567890G":
                nom = "Dupont";
                break;
            case "0987654321G":
                nom = "MICHEL";
                break;
            default:
                nom = "inconnu";
                break;
        }

        responseObserver.onNext(EtudiantNameReply
            .newBuilder()
                .setName(nom)
                .build()
        );

        responseObserver.onCompleted();
    }
}
