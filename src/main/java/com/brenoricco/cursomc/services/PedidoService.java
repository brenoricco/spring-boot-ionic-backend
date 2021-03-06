package com.brenoricco.cursomc.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brenoricco.cursomc.domains.ItemPedido;
import com.brenoricco.cursomc.domains.PagamentoComBoleto;
import com.brenoricco.cursomc.domains.Pedido;
import com.brenoricco.cursomc.domains.enums.EstadoPagamento;
import com.brenoricco.cursomc.repositories.ItemPedidoRepository;
import com.brenoricco.cursomc.repositories.PagamentoRepository;
import com.brenoricco.cursomc.repositories.PedidoRepository;
import com.brenoricco.cursomc.repositories.ProdutoRepository;
import com.brenoricco.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;
    
    @Autowired
    private BoletoService boletoService;
    
    @Autowired
    private PagamentoRepository pagamentoRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for(ItemPedido ip : obj.getItens() ) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoRepository.findById(ip.getProduto().getId()).get().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}

}
