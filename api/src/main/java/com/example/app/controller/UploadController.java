package com.example.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Value("${upload.path:./../static/images/}")
    private String uploadPath;

    @PostMapping("/file/single")
    public Mono<Void> upload(
                             @RequestPart("fileToUpload") Mono<FilePart> filePartMono){
        return  filePartMono
                .doOnNext(fp -> System.out.println("Received File : " + fp.filename()))
                .flatMap(fp -> fp.transferTo(Path.of(uploadPath).resolve(fp.filename())))
                .then();
    }

    @PostMapping("/file/multi")
    public Mono<Void> upload(@RequestPart("files") Flux<FilePart> partFlux){
        return  partFlux
                .doOnNext(fp -> System.out.println(fp.filename()))
                .flatMap(fp -> fp.transferTo(Path.of(uploadPath).resolve(fp.filename())))
                .then();
    }

    @GetMapping(value = "/images",produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<CharSequence> upload(){
        return  Flux
                .fromArray(Path.of(uploadPath).toFile().list());
    }

}
