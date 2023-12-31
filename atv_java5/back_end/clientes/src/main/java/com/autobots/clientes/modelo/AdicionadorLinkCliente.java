package com.autobots.clientes.modelo;


import com.autobots.clientes.controles.ClienteControle;
import com.autobots.clientes.entidades.Cliente;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdicionadorLinkCliente implements AdicionadorLink<Cliente> {

    @Override
    public void adicionarLink(List<Cliente> lista) {
        for (Cliente cliente : lista) {
            long id = cliente.getId();
            Link linkProprio = WebMvcLinkBuilder
                    .linkTo(WebMvcLinkBuilder
                            .methodOn(ClienteControle.class)
                            .obterCliente(id))
                    .withSelfRel();
            cliente.add(linkProprio);
        }
    }

    @Override
    public void adicionarLink(Cliente objeto) {
        Link linkProprio = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(ClienteControle.class)
                        .obterClientes())
                .withRel("clientes");
        objeto.add(linkProprio);
    }
}