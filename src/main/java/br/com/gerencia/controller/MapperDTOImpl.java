package br.com.gerencia.controller;

import br.com.gerencia.model.Categoria;
import br.com.gerencia.model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2016-12-24T14:48:03-0200",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
public class MapperDTOImpl implements MapperDTO {

    @Override
    public List<ProdutoDTO> produtosToProdutosDTO(List<Produto> produtos) {
        if ( produtos == null ) {
            return null;
        }

        List<ProdutoDTO> list = new ArrayList<ProdutoDTO>();
        for ( Produto produto : produtos ) {
            list.add( produtoToProdutoDTO( produto ) );
        }

        return list;
    }

    @Override
    public ProdutoDTO produtoToProdutoDTO(Produto produto) {
        if ( produto == null ) {
            return null;
        }

        ProdutoDTO produtoDTO_ = new ProdutoDTO();

        produtoDTO_.setId( produto.getId() );
        produtoDTO_.setChaveProduto( produto.getChaveProduto() );
        produtoDTO_.setNomeProduto( produto.getNomeProduto() );
        produtoDTO_.setCodigoBarras( produto.getCodigoBarras() );
        produtoDTO_.setPrecoCompra( produto.getPrecoCompra() );
        produtoDTO_.setPrecoUnitario( produto.getPrecoUnitario() );
        produtoDTO_.setDescricaoProduto( produto.getDescricaoProduto() );
        produtoDTO_.setInfoTecnicas( produto.getInfoTecnicas() );
        produtoDTO_.setPrecoCompraNoFormatado( produto.getPrecoCompraNoFormatado() );
        produtoDTO_.setPrecoUnitarioNoFormatado( produto.getPrecoUnitarioNoFormatado() );
        List<Long> list = produto.getCategoriaId();
        if ( list != null ) {
            produtoDTO_.setCategoriaId(       new ArrayList<Long>( list )
            );
        }

        return produtoDTO_;
    }

    @Override
    public Produto produtoDTOToProduto(ProdutoDTO produtoDTO) {
        if ( produtoDTO == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setId( produtoDTO.getId() );
        produto.setChaveProduto( produtoDTO.getChaveProduto() );
        produto.setNomeProduto( produtoDTO.getNomeProduto() );
        produto.setCodigoBarras( produtoDTO.getCodigoBarras() );
        produto.setPrecoCompra( produtoDTO.getPrecoCompra() );
        produto.setPrecoUnitario( produtoDTO.getPrecoUnitario() );
        produto.setDescricaoProduto( produtoDTO.getDescricaoProduto() );
        produto.setPrecoCompraNoFormatado( produtoDTO.getPrecoCompraNoFormatado() );
        produto.setPrecoUnitarioNoFormatado( produtoDTO.getPrecoUnitarioNoFormatado() );
        List<Long> list = produtoDTO.getCategoriaId();
        if ( list != null ) {
            produto.setCategoriaId(       new ArrayList<Long>( list )
            );
        }
        produto.setInfoTecnicas( produtoDTO.getInfoTecnicas() );

        return produto;
    }

    @Override
    public CategoriaDTO categoriaToCategoriaDTO(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setId( categoria.getId() );
        categoriaDTO.setChaveCategoria( categoria.getChaveCategoria() );
        categoriaDTO.setNome( categoria.getNome() );
        categoriaDTO.setDescricao( categoria.getDescricao() );
        categoriaDTO.setProduto( produtoToProdutoDTO( categoria.getProduto() ) );

        return categoriaDTO;
    }

    @Override
    public Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO) {
        if ( categoriaDTO == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( categoriaDTO.getId() );
        categoria.setChaveCategoria( categoriaDTO.getChaveCategoria() );
        categoria.setNome( categoriaDTO.getNome() );
        categoria.setDescricao( categoriaDTO.getDescricao() );
        categoria.setProduto( produtoDTOToProduto( categoriaDTO.getProduto() ) );

        return categoria;
    }
}
