package br.com.gerencia.controller;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.gerencia.model.Categoria;
import br.com.gerencia.model.Produto;
@Mapper
public interface MapperDTO {
	
	MapperDTO INSTANCE = Mappers.getMapper( MapperDTO.class );

	List<ProdutoDTO> produtosToProdutosDTO(List<Produto> produtos);

	ProdutoDTO produtoToProdutoDTO(Produto produto);
	
	Produto produtoDTOToProduto(ProdutoDTO produtoDTO);
	
	CategoriaDTO categoriaToCategoriaDTO(Categoria categoria);
	
	Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO);
}
