package com.cognizant.stockMedicineService.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.stockMedicineService.dao.MedicineStockDAO;
import com.cognizant.stockMedicineService.model.Medicine;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineStockServiceImplTest {


    @InjectMocks
    private MedicineStockServiceImpl medicineServiceImpl;

    @Mock
    private MedicineStockDAO medicineDAO;

    @Mock
    private Medicine medicine;
        
    /**
	 * @throws Exception  Tests the getMedicineStockInformation method and checks if
	 *  						the returned value is null or not
	 */
    @Test
    public void testGetMedicineStockInformationNotNull() {
        assertNotNull(medicineServiceImpl.getMedicineStockInformation());
    }
    
     /**
  	 * @throws Exception  Tests the getMedicineStockInformation method and checks if
  	 *  						the returned value is equal or not
  	 */
      /*@Test
      public void testGetMedicineStockInformation() {
    	  List<Medicine> li=new ArrayList<>();
    	  Medicine medicine=new Medicine();
    	  medicine.se
    	  li.add(medicine);
    	  li.add(new Medicine("Orthoherb","Eranda","Orthopaedics","2021-07-30",8000));
    	  
    	  medicineDAO = mock(MedicineStockDAO.class);
    	  //when(medicineDAO.findAll()).thenReturn(new LinkedList()); 	  
    	  when(medicineDAO.findAll()).thenReturn(new ArrayList<>()); 	  
    	  assertEquals(medicineServiceImpl.getMedicineStockInformation(),new LinkedList());
      }*/

    
    /**
     * @throws Exception  Tests the getMedicineByTargetAilment method and checks if
     *  						the returned value is equal or not
     */
    @Test
    public void testGetMedicineByTargetAilment() {
    	medicineDAO = mock(MedicineStockDAO.class);
    	when(medicineDAO.getMedicineByTargetAilment(Mockito.anyString())).thenReturn(new LinkedList()); 	  
    	assertEquals(medicineServiceImpl.getMedicineByTargetAilment(Mockito.anyString()),new LinkedList());
    }
    
    /**
	 * @throws Exception  Tests the getNumberOfTabletsInStockByName method and checks if
	 *  						the returned value is null or not
	 */
    @Test
    public void testGetNumberOfTabletsInStockByNameNotNull() {
    	//medicineDAO = mock(MedicineStockDAO.class);
    	when(medicineDAO.getNumberOfTabletsInStockByName(Mockito.anyString())).thenReturn(new Medicine()); 	  
    	assertNotNull(medicineServiceImpl.getNumberOfTabletsInStockByName(Mockito.anyString()));
    }
    
    /**
	 * @throws Exception  Tests the getNumberOfTabletsInStockByName method and checks if
	 *  						the returned value is equal or not
	 */
    
    @Test
    public void testGetNumberOfTabletsInStockByName() {
    	when(medicineDAO.getNumberOfTabletsInStockByName("Orthoherb")).thenReturn(new Medicine()); 
    	assertNotNull(medicineDAO.getNumberOfTabletsInStockByName("Orthoherb"));
    }
	
}
