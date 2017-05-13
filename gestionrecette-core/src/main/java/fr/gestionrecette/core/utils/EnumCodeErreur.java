/**
 * 
 */
package com.angata.core.utils;

/**
 * @author knc
 * DEF_1 = donnée non trouvée en BD
 * DEF_2 = contenu json de la requete incorrect
 * DEF_3 = Accès non autorisé (login)
 * DEF_4 = erreur fonctionnel
 * DEF_5 = erreur dans l'entete Authrorization
 * DEF_6 = code d'activation du compte incorrect
 * DEF_7 = paramètres requis non renseignés
 * DEF_8 = un utilisateur possedant cet email existe déjà
 */
public enum EnumCodeErreur {
	/** DEF_1 = donnée non trouvée en BD */
	DEF_1,
	/**DEF_2 = contenu json de la requete incorrect*/
	DEF_2,
	/** DEF_3 = Accès non autorisé (login) */
	DEF_3,
	/** DEF_4 = erreur fonctionnel */
	DEF_4,
	/** DEF_5 = erreur dans l'entete Authrorization */
	DEF_5,
	/** DEF_6 = code d'activation du compte incorrect */
	DEF_6,
	
	/** DEF_6 = paramères requis nons renseignés */
	DEF_7,
	/** DEF_9 =un utilisateur possedant cet email existe déjà */
	DEF_8,
	
	/** DEF_9 =aucun utilisateur n'a été trouvé avec cet email et ce mot de passe */
	DEF_9;
}
