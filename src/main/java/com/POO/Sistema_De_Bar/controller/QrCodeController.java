package com.POO.Sistema_De_Bar.controller;

import com.POO.Sistema_De_Bar.service.QrCodeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeService qrCodeService;

    public QrCodeController(QrCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @GetMapping(value = "/mesa/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] gerarQrCodeMesa(@PathVariable Long id) {
        String linkParaOCliente = "http://localhost:8080/comandas/" + id + "/resumo";

        return qrCodeService.gerarQrCode(linkParaOCliente, 300, 300);
    }
}