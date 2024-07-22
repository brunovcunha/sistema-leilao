package iftm.edu.leilao.service;

import iftm.edu.leilao.model.ItemDeLeilao;
import iftm.edu.leilao.model.Lance;
import iftm.edu.leilao.repository.ItemLeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDeLeilaoService {

    @Autowired
    private ItemLeilaoRepository repository;

    @Autowired
    private LanceService lanceService;

    public void salvarItem(ItemDeLeilao item) {
        repository.save(item);
    }

    public ItemDeLeilao buscarItemDeLeilaoPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Item nao encontrado"));
    }

    public List<ItemDeLeilao> buscarItensDeLeilao() {
        return repository.findAll();
    }

    public ItemDeLeilao atualizarItemDeLeilao(Integer id, ItemDeLeilao item) {
        item.setId(id);
        return  repository.save(item);
    }

    public void removerItemDeLeilao(Integer id) {
        repository.deleteById(id);
    }

    public ItemDeLeilao registrarLance(Integer id, Lance lance) {
        ItemDeLeilao itemLeilao = buscarItemDeLeilaoPorId(id);

        if(itemLeilao.isLeilaoAberto()) {
            lance = lanceService.salvarLance(lance);

            itemLeilao.getLancesRecebidos().add(lance);

            if(itemLeilao.getLanceVencedor() == null || (itemLeilao.getLanceVencedor() != null && lance.getValor() > itemLeilao.getLanceVencedor().getValor())) {
                itemLeilao.setLanceVencedor(lance);
            }

            return atualizarItemDeLeilao(id, itemLeilao);
        }

        return itemLeilao;
    }

    public Lance fecharLeilao(Integer id) {
        ItemDeLeilao item = buscarItemDeLeilaoPorId(id);
        item.setLeilaoAberto(false);
        repository.save(item);
        return item.getLanceVencedor();
    }

}
