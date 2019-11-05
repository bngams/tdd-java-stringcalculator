TDD Approach
===================================
Implements tests first, then implement corresponding code


## Etape 1
Créer les tests
Si StringCalculator.add recoit plus deux nombres, alors cela déclenche une  RuntimeException
whenMoreThan2NumbersAreUsedThenExceptionIsThrown
L’inverse du cas précédent
when2NumbersAreUsedThenNoExceptionIsThrown
Si StringCalculator.add reçoit des valeurs non numériques
whenNonNumberIsUsedThenExceptionIsThrown
Exemple StringCalculator.add(“0, X”);
Réaliser l’implémentation correspondante pour passer les tests


## Etape 2
Créer les tests
Quand la méthode recoit une chaine de caractère vide, alors elle renvoie 0
whenEmptyStringIsUsedThenReturnValueIs0
Réaliser l’implémentation correspondante pour passer les tests


## Etape 3 
Créer les tests
La méthode doit calculer la somme des nombres reçus
whenOneNumberIsUsedThenReturnValueIsThatSameNumber
whenTwoNumbersAreUsedThenReturnValueIsTheirSum
Réaliser l’implémentation correspondante pour passer les tests

## Etape 4
Créer ou refactoriser les tests (a vous de définir la méthode a créer ou à modifier / renommer) pour répondre à ce scénario:
Autoriser la méthode Add à gérer un nombre inconnu de nombres
Réaliser l’implémentation correspondante pour passer les tests

##Etape 5
Autorisez la méthode Add à gérer les nouvelles lignes entre les nombres (au lieu de virgules).
L’entrée suivante est ok: "1 \ n2,3" (sera égal à 6)

## Etape 6
Soutenir différents délimiteurs
Pour changer un délimiteur, le début de la chaîne contiendra une ligne distincte ressemblant à ceci: "// [délimiteur] \n [nombres…]", par exemple "//; \ n1; 2" doit renvoyer trois où valeur par défaut le délimiteur est ';' .
La première ligne est facultative. Tous les scénarios existants doivent toujours être pris en charge

## Etape 7
Appeler Ajouter avec un nombre négatif lève une exception "Négatifs non autorisés" - et le négatif qui a été passé. S'il y a plusieurs négatifs, affichez-les tous dans le message d'exception, arrêtez-le ici si vous êtes débutant.

## Etape 8
Les nombres supérieurs à 1000 doivent être ignorés. Il faut donc ajouter 2 + 1001 = 2.

## Etape 9
Les délimiteurs peuvent être de n'importe quelle longueur au format suivant: "// [délimiteur] \ n" par exemple: "// [---] \ n1 --- 2 --- 3" doit renvoyer 6

## Etape 10
Autorisez plusieurs délimiteurs comme celui-ci: "// [delim1] [delim2] \ n" par exemple "// [-] [%] \ n1-2% 3" doit renvoyer 6.
Assurez-vous que vous pouvez également gérer plusieurs délimiteurs avec une longueur supérieure à un caractère.
