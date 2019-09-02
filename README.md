Aqui está minha classe de web Scraper. Não sabia muito bem como aplicar na página pelo link então acabei separando páginas HTML baixadas da wikipédia e pegando:

* Nome dos times 
* Apelido dos times
* Fundação dos times
* Estadio próprio
* Capacidade do estádio
* Treinador
* Liga
* Nome do arquivo
* Tamanho do arquivo

No caso do arquivo .zip irei também enviar por email por segurança.
A pasta extraida do "times.zip" deve ser colocada na pasta tmp do linux para que possa abrir as páginas HTML.

Para usar o programa, colocar todos menos o arquivo "times.zip", que deve estar na pasta "tmp" do Linux como havia dito acima. Assim que estiver tudo pronto, abra a pasta na qual você utilizou para colocar tudo no terminal do linux e digite:
>"javac Classe.java"

feito isso escreva:
>"java Classe < pub.in" para aparecer tudo no terminal

Caso queira gerar outro arquivo com a saída digite: 
>"java Classe < pub.in > saida.out" 

ai irá criar um arquivo .out com a saida do programa.
