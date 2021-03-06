package fr.pizzeria.ihm;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import 	org.apache.commons.lang3.time.DateFormatUtils;

import fr.pizzeria.exception.SaisieEntierException;

public class Menu {
	
	public static void Calendar(){
		Date date = null;
		Calendar.getInstance().setTime(date);
		
	}

	private static final int CHOIX_SORTIR = 99;
	private Map<Integer, Action> actions = new HashMap<>();
	private IhmHelper ihmHelper;

	public Menu(IhmHelper helper) {
		this.actions.put(1, new ListerPizzaAction(helper));
		this.actions.put(2, new AjouterPizzaAction(helper));
		this.actions.put(3, new ModifierPizzaAction(helper));
		this.actions.put(4, new SupprimerPizzaAction(helper));
		this.actions.put(5, new ListerClientAction(helper));
		this.actions.put(6, new AjouterClientAction(helper));
		this.actions.put(7, new CrediterClientAction(helper));
		this.actions.put(8, new DebiterClientAction(helper));
		this.actions.put(9, new ListerLivreurAction(helper));
		this.actions.put(10, new AfficherCompteStatAction(helper));
		this.actions.put(11, new VirementClientAction(helper));
		
		//
		////****** Reflection*******/////
		//Reflection reflection = new Reflection();
		//Set<Class<?>> anotated = reflection.getTypesAnnotatedWith(ActionAnnotation.class);
		//AtomicInteger yournotkillme = new AtomicInteger(0);
		
		//int index = 0;
		
		//Pizza pizza = new Pizza
		//annotated.forEach(uneClasse ->{
		//	try{
		//		//// index++
		//		constructor<?> constructor = uneClasse.geConstructor(I.)
		//	}
		//})

		//// fin reflection
		//**/ 
		
		this.ihmHelper = helper;
	}

	public void start() {
		boolean result = false;
		do {
			affichageM();
			result = choisir();
		} while (!result);
	}

	public void affichageM() {
		
		System.out.println("***** Super Pizzeria Administration *****");

		//// maven afficher la date du jour avec la librairie  du td 
		Calendar now = Calendar.getInstance(); 
		DateFormatUtils.format(now, "yyyy.MM.dd G 'at' HH:mm:ss z");
		System.out.println(DateFormatUtils.format(now, "dd/MM-HH:mm"));
		

		for (Integer numero : actions.keySet()) {
			Action ActionEnCours = actions.get(numero);
			String libelleAction = ActionEnCours.getLibelle();
			System.out.println(numero + " " + libelleAction);

		}
		System.out.println(CHOIX_SORTIR + ". Quitter" + "\n");
	}

	private void SimpleDateFormat(Calendar now) {
		// TODO Auto-generated method stub
		
	}

	public boolean choisir() {
		System.out.println("Veuillez choisir une option");
		int choix = 0;
		try {
			// Instructions susceptibles de provoquer des erreurs;

			choix = ihmHelper.saisirEntier();
			if (!actions.containsKey(choix)) {
				if (choix != CHOIX_SORTIR) {
					System.out.println("Erreur de saisie, veuillez recommencer!" + "\n");
				}
			} else {

				Action LaBonneAction = actions.get(choix);
				LaBonneAction.execute();

			}
		} catch (SaisieEntierException e) {
			System.out.println(e.getMessage());
		}

		return choix == CHOIX_SORTIR;
	}

}
