package springMvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;
import fr.pizzeria.model.Client;

@Controller
@CrossOrigin // annotation pour autoriser accer au donner d'un serveur exterieur (CROSS)
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private IClientRepository clientR;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Client> findAll() {

		return clientR.findAll();

	}

	@RequestMapping(value = "/{idC}/solde", method = RequestMethod.POST)
	@ResponseBody
	public RepBody modifierSoldeClient(@PathVariable Integer idC, @RequestBody RequetteBody rb) {

		RepBody rpb = new RepBody();
		Client client = clientR.findOne(idC);

		if (rb.getOperation().equals("Credit")) {
			try {
				client.crediterCompte(rb.getMontant());
				client.setSolde(client.getSolde());
				rpb.setSucces(true);
				rpb.setSolde(client.getSolde());
				rpb.setMsg("Compte créditer de: " + rb.getMontant() + " €" + " le nouveau solde est de: "
						+ client.getSolde() + " €");
				clientR.save(client);

			} catch (CreditException e) {
				rpb.setSucces(false);
				rpb.setSolde(client.getSolde());
				rpb.setMsg("Opération impossible (limite max )");

			}
		} else if (rb.getOperation().equals("Debit")) {

			try {
				client.debiterCompte(rb.getMontant());
				client.setSolde(client.getSolde());
				rpb.setSucces(true);
				rpb.setSolde(client.getSolde());
				rpb.setMsg("Compte débiter de: " + rb.getMontant() + " €" + " le nouveau solde est de: "
						+ client.getSolde() + " €");
				clientR.save(client);

			} catch (DebitException e) {
				rpb.setSucces(false);
				rpb.setSolde(client.getSolde());
				rpb.setMsg("Opération impossible (limite Min )");

			}

		}
		return rpb;
	}

}
