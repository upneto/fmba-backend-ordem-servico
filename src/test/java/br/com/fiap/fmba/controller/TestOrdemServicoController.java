/**
 * 
 */
package br.com.fiap.fmba.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import br.com.fiap.fmba.controller.payload.OrdemServicoPayload;
import br.com.fiap.fmba.persistence.model.OrdemServico;
import br.com.fiap.fmba.resources.exception.DaoException;
import br.com.fiap.fmba.service.OrdemServicoService;

/**
 * @author Ulisses Neto
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TestOrdemServicoController {

	@Mock
	private OrdemServicoService mockService;

	@InjectMocks
	private OrdemServicoController controller;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUpBefore() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	
	public OrdemServico getMock() {
		return OrdemServico.builder()
				.id(123)				
				.build();
	}
	
	public OrdemServicoPayload getMockPayload() {
		return OrdemServicoPayload.builder()
				.id(123)				
				.build();
	}

	/**
	 * Test method for
	 * {@link br.com.fiap.fmba.controller.OrdemServicoController#findAll()}.
	 * @throws DaoException 
	 */
	@Test
	public void testFindAll() throws DaoException {
		
		List<OrdemServicoPayload> lista = new ArrayList<OrdemServicoPayload>();
		lista.add(getMockPayload());
		
		Mockito.when(mockService.findAll()).thenReturn(lista);
		
		ResponseEntity<List<OrdemServicoPayload>> findAll = controller.findAll();

		Assert.assertNotNull(findAll);
        Assert.assertEquals(200, findAll.getStatusCode().value());
        Assert.assertEquals(lista.get(0).getId(), findAll.getBody().get(0).getId());
	}

	/**
	 * Test method for
	 * {@link br.com.fiap.fmba.controller.OrdemServicoController#findBy(long)}.
	 * @throws DaoException 
	 */
	@Test
	public void testFindBy() throws DaoException {
		
		Mockito.when(mockService.find(Mockito.anyLong())).thenReturn(getMockPayload());
		
		ResponseEntity<OrdemServicoPayload> findBy = controller.findBy(123l);

		Assert.assertNotNull(findBy);
        Assert.assertEquals(200, findBy.getStatusCode().value());
        Assert.assertEquals(getMock().getId(), findBy.getBody().getId());
	}

	/**
	 * Test method for
	 * {@link br.com.fiap.fmba.controller.OrdemServicoController#insert(br.com.fiap.fmba.persistence.model.OrdemServico)}.
	 * @throws DaoException 
	 */
	@Test
	public void testInsert() throws DaoException {
				
		ResponseEntity<?> insert = controller.insert(getMockPayload());

		Assert.assertNotNull(insert);
        Assert.assertEquals(200, insert.getStatusCode().value());
	}

	/**
	 * Test method for
	 * {@link br.com.fiap.fmba.controller.OrdemServicoController#update(br.com.fiap.fmba.persistence.model.OrdemServico)}.
	 * @throws DaoException 
	 */
	@Test
	public void testUpdate() throws DaoException {
		ResponseEntity<?> update = controller.update(getMockPayload());

		Assert.assertNotNull(update);
        Assert.assertEquals(200, update.getStatusCode().value());
	}

	/**
	 * Test method for
	 * {@link br.com.fiap.fmba.controller.OrdemServicoController#delete(long)}.
	 * @throws DaoException 
	 */
	@Test
	public void testDelete() throws DaoException {
		ResponseEntity<?> delete = controller.delete(123);

		Assert.assertNotNull(delete);
        Assert.assertEquals(200, delete.getStatusCode().value());
	}

}
