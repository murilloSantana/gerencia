package br.com.gerencia.controller;

import br.com.gerencia.model.Categoria;
import br.com.gerencia.model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-01-21T12:47:57-0200",
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

        produtoDTO_.setChaveProduto( produto.getChaveProduto() );
        produtoDTO_.setNomeProduto( produto.getNomeProduto() );
        produtoDTO_.setCodigoBarras( produto.getCodigoBarras() );
        produtoDTO_.setPrecoCompra( produto.getPrecoCompra() );
        produtoDTO_.setPrecoUnitario( produto.getPrecoUnitario() );
        produtoDTO_.setDescricaoProduto( produto.getDescricaoProduto() );
        produtoDTO_.setPrecoCompraNoFormatado( produto.getPrecoCompraNoFormatado() );
        produtoDTO_.setPrecoUnitarioNoFormatado( produto.getPrecoUnitarioNoFormatado() );
        List<CategoriaDTO> list = categoriaListToCategoriaDTOList( produto.getCategorias() );
        if ( list != null ) {
            produtoDTO_.setCategorias( list );
        }
        List<Long> list_ = produto.getCategoriaId();
        if ( list_ != null ) {
            produtoDTO_.setCategoriaId(       new ArrayList<Long>( list_ )
            );
        }
        produtoDTO_.setInfoTecnicas( produto.getInfoTecnicas() );

        return produtoDTO_;
    }

    @Override
    public Produto produtoDTOToProduto(ProdutoDTO produtoDTO) {
        if ( produtoDTO == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setChaveProduto( produtoDTO.getChaveProduto() );
        produto.setNomeProduto( produtoDTO.getNomeProduto() );
        produto.setCodigoBarras( produtoDTO.getCodigoBarras() );
        produto.setPrecoCompra( produtoDTO.getPrecoCompra() );
        produto.setPrecoUnitario( produtoDTO.getPrecoUnitario() );
        produto.setDescricaoProduto( produtoDTO.getDescricaoProduto() );
        produto.setPrecoCompraNoFormatado( produtoDTO.getPrecoCompraNoFormatado() );
        produto.setPrecoUnitarioNoFormatado( produtoDTO.getPrecoUnitarioNoFormatado() );
        List<Categoria> list = categoriaDTOListToCategoriaList( produtoDTO.getCategorias() );
        if ( list != null ) {
            produto.setCategorias( list );
        }
        List<Long> list_ = produtoDTO.getCategoriaId();
        if ( list_ != null ) {
            produto.setCategoriaId(       new ArrayList<Long>( list_ )
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

        CategoriaDTO categoriaDTO_ = new CategoriaDTO();

        categoriaDTO_.setChaveCategoria( categoria.getChaveCategoria() );
        categoriaDTO_.setNome( categoria.getNome() );
        categoriaDTO_.setDescricao( categoria.getDescricao() );
        categoriaDTO_.setProduto( produtoToProdutoDTO( categoria.getProduto() ) );

        return categoriaDTO_;
    }

    @Override
    public Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO) {
        if ( categoriaDTO == null ) {
            return null;
        }

        Categoria categoria_ = new Categoria();

        categoria_.setChaveCategoria( categoriaDTO.getChaveCategoria() );
        categoria_.setNome( categoriaDTO.getNome() );
        categoria_.setDescricao( categoriaDTO.getDescricao() );
        categoria_.setProduto( produtoDTOToProduto( categoriaDTO.getProduto() ) );

        return categoria_;
    }

    protected List<CategoriaDTO> categoriaListToCategoriaDTOList(List<Categoria> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoriaDTO> list_ = new ArrayList<CategoriaDTO>();
        for ( Categoria categoria : list ) {
            list_.add( categoriaToCategoriaDTO( categoria ) );
        }

        return list_;
    }

    protected List<Categoria> categoriaDTOListToCategoriaList(List<CategoriaDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Categoria> list_ = new ArrayList<Categoria>();
        for ( CategoriaDTO categoriaDTO : list ) {
            list_.add( categoriaDTOToCategoria( categoriaDTO ) );
        }

        return list_;
    }
}
