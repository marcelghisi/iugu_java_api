import java.util.ArrayList;
import java.util.List;

import com.iugu.Iugu;
import com.iugu.model.Address;
import com.iugu.model.Data;
import com.iugu.model.MailDirectCharge;
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
		

		
		
		Data data = new Data("4242424242424242","123","Joao","Silva","12","2013");
		PaymentTokenResponse response = new PaymentService().createToken(
				new PaymentToken("96461997-b6a0-48fb-808b-4f16ad88c718", PayableWith.CREDIT_CARD, true,data));
		System.out.println(response.getId());
		String token = response.getId();

		Item item = new Item("Refeição",1,100);
		List<Item> items = new ArrayList<Item>(0);
		items.add(item);
		
		Address address = new Address("Rua Miguel Teles Junior", "129", "Sao Paulo", "SP", "BR","01540-040");
		
		Payer payer = new Payer("12312312312","MARCEL JOSE DA SILVA GHISI","11","33995090","teste@teste.com",address);
		
		ChargeResponse responseDirectCharge = new PaymentService().createDirectCharge(
				new MailDirectCharge(token,"teste@teste.com",items,payer,null,null,null));
		System.out.println(responseDirectCharge.getMessage());
		
	}

}
