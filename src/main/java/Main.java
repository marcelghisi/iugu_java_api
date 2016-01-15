import java.util.ArrayList;
import java.util.List;

import com.iugu.Iugu;
import com.iugu.model.Address;
import com.iugu.model.Data;
import com.iugu.model.TokenDirectCharge;
import com.iugu.model.Item;
import com.iugu.model.PayableWith;
import com.iugu.model.Payer;
import com.iugu.model.PaymentToken;
import com.iugu.responses.ChargeResponse;
import com.iugu.responses.PaymentTokenResponse;
import com.iugu.services.PaymentService;

public class Main {

	public static void main(String[] args) {

		//Testa criacao de uma fatura a ser paga para um email x
		Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		//Funfa cria fatura e envia boleto com invoice
		//Iugu.init("21ab6ca14384901acaea1793b91cdc98");
		//InvoiceResponse response = new InvoiceService().create(new Invoice("marcel.ghisi@gmail.com", new Date(), new Item("teste", 1, 100)));
		//System.out.println(response.getId());
		

		
		

		
	}

}
