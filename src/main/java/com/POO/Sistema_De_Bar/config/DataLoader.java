package com.POO.Sistema_De_Bar.config;

import com.POO.Sistema_De_Bar.model.*;
import com.POO.Sistema_De_Bar.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final MesaRepository mesaRepository;
    private final ProdutoRepository produtoRepository;
    private final ConfiguracaoRepository configuracaoRepository;

    public DataLoader(MesaRepository mesaRepository,
                      ProdutoRepository produtoRepository,
                      ConfiguracaoRepository configuracaoRepository) {
        this.mesaRepository = mesaRepository;
        this.produtoRepository = produtoRepository;
        this.configuracaoRepository = configuracaoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        carregarConfiguracao();
        carregarMesas();
        carregarProdutos();
    }

    private void carregarConfiguracao() {
        if (configuracaoRepository.count() == 0) {
            ConfiguracaoModel config = new ConfiguracaoModel();
            config.setValorCovert(new BigDecimal("15.00"));
            config.setPecentualGorjetaBebida(new BigDecimal("10.00"));
            config.setPecentualGorjetaComida(new BigDecimal("15.00"));

            configuracaoRepository.save(config);
            System.out.println("✅ Configuração inicial carregada.");
        }
    }

    private void carregarMesas() {
        if (mesaRepository.count() == 0) {
            // Cria 10 mesas numeradas de 1 a 10
            for (int i = 1; i <= 10; i++) {
                MesaModel mesa = new MesaModel();
                mesa.setNumero(i);
                mesa.setStatus(StatusMesa.LIVRE);
                mesaRepository.save(mesa);
            }
            System.out.println("✅ 10 Mesas cadastradas.");
        }
    }

    private void carregarProdutos() {
        if (produtoRepository.count() == 0) {
            ProdutoModel p1 = new ProdutoModel();
            p1.setNome("Cerveja Artesanal");
            p1.setDescricao("Cerveja Lager 600ml");
            p1.setPreco(new BigDecimal("22.00"));
            p1.setCategoria(CategoriaProduto.BEBIDA);
            p1.setDisponivel(true);

            ProdutoModel p2 = new ProdutoModel();
            p2.setNome("Refrigerante Cola");
            p2.setDescricao("Lata 350ml gelada");
            p2.setPreco(new BigDecimal("8.00"));
            p2.setCategoria(CategoriaProduto.BEBIDA);
            p2.setDisponivel(true);

            ProdutoModel p3 = new ProdutoModel();
            p3.setNome("Porção de Fritas");
            p3.setDescricao("500g de batata com cheddar e bacon");
            p3.setPreco(new BigDecimal("35.00"));
            p3.setCategoria(CategoriaProduto.COMIDA);
            p3.setDisponivel(true);

            ProdutoModel p4 = new ProdutoModel();
            p4.setNome("Hambúrguer da Casa");
            p4.setDescricao("Pão brioche, 180g carne, queijo e salada");
            p4.setPreco(new BigDecimal("42.00"));
            p4.setCategoria(CategoriaProduto.COMIDA);
            p4.setDisponivel(true);

            produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
            System.out.println("✅ Cardápio inicial cadastrado.");
        }
    }
}