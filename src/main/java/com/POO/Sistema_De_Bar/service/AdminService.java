package com.POO.Sistema_De_Bar.service;

import com.POO.Sistema_De_Bar.dto.ConfiguracaoDTO;
import com.POO.Sistema_De_Bar.dto.MesaDTO;
import com.POO.Sistema_De_Bar.dto.ProdutoDTO;
import com.POO.Sistema_De_Bar.model.*;
import com.POO.Sistema_De_Bar.repository.ComandaRepository;
import com.POO.Sistema_De_Bar.repository.ConfiguracaoRepository;
import com.POO.Sistema_De_Bar.repository.MesaRepository;
import com.POO.Sistema_De_Bar.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final ProdutoRepository produtoRepository;
    private final ConfiguracaoRepository configuracaoRepository;
    private final MesaRepository mesaRepository;
    private final ComandaRepository comandaRepository;

    public AdminService(ProdutoRepository produtoRepository, ConfiguracaoRepository configuracaoRepository, MesaRepository mesaRepository, ComandaRepository comandaRepository) {
        this.produtoRepository = produtoRepository;
        this.configuracaoRepository = configuracaoRepository;
        this.mesaRepository = mesaRepository;
        this.comandaRepository = comandaRepository;
    }

    public List<ProdutoModel> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public MesaModel cadastrarMesa(MesaDTO dados) {
        if (mesaRepository.findByNumeroAndAtivaTrue(dados.numero()).isPresent()) {
            throw new RuntimeException("Já existe uma mesa com o número " + dados.numero());
        }

        MesaModel mesa = new MesaModel();
        mesa.setNumero(dados.numero());
        mesa.setStatus(StatusMesa.LIVRE);
        return mesaRepository.save(mesa);
    }

    public void deletarMesa(Long id) {
        MesaModel mesa = mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));
        if (comandaRepository.findByMesaIdAndStatus(id, StatusComanda.ABERTA).isPresent()) {
            throw new RuntimeException("Não é possível remover uma mesa que está ocupada.");
        }
        mesa.setAtiva(false);
        mesaRepository.save(mesa);
    }

    public ProdutoModel cadastrarProduto(ProdutoDTO dados) {
        ProdutoModel produto = new ProdutoModel();
        produto.setNome(dados.nome());
        produto.setDescricao(dados.descricao());
        produto.setPreco(dados.preco());
        produto.setCategoria(dados.categoria());
        produto.setDisponivel(true);

        return produtoRepository.save(produto);
    }

    public ProdutoModel atualizarProduto(Long id, ProdutoDTO dados) {
        ProdutoModel produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (dados.nome() != null) produto.setNome(dados.nome());
        if (dados.descricao() != null) produto.setDescricao(dados.descricao());
        if (dados.preco() != null) produto.setPreco(dados.preco());
        if (dados.categoria() != null) produto.setCategoria(dados.categoria());
        if (dados.disponivel() != null) produto.setDisponivel(dados.disponivel());

        return produtoRepository.save(produto);
    }

    public ConfiguracaoModel atualizarConfiguracao(ConfiguracaoDTO dados) {
        ConfiguracaoModel config = configuracaoRepository.findAll().stream().findFirst().orElseThrow(() -> new RuntimeException("Configuração não inicializada (rode o DataLoader)"));

        if (dados.valorCouvert() != null) config.setValorCovert(dados.valorCouvert());
        if (dados.percentualGorjetaComida() != null) config.setPecentualGorjetaComida(dados.percentualGorjetaComida());
        if (dados.percentualGorjetaBebida() != null) config.setPecentualGorjetaBebida(dados.percentualGorjetaBebida());

        return configuracaoRepository.save(config);
    }
}