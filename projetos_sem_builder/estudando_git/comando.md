```
###### *`*Escrevendo bem um COMMIT**`

-Escrever com nomaximo 50 caracteres, iniciar com letra MAIUSCULA e não acrescentar PONTO final
-Escrever na voz imperativa seja no Ingles ou Portugues
ex: Ingles
correto: Add a feature  ----------------------> Incorreto= Added a feature
correto: Modify an existing feature ----------> Incorreto= Modified an existing feature
correto: Remove a feature --------------------> Incorreto= Removed a feature
modelo: if applied, this commit will:
 Add payment integration
 Update database configurations
 Remove redundant code

ex:Portugues
correto: Adiciona a funcionalidade X ---------------> Incorreto= Funcionalidade X adicionada
correto: Modifica uma funcionalidade existente------> Incorreto= Funcionalidade Y modificada
modelo: Se aceito este commit:
 Adiciona metodo de pagamento
 Atualiza configurações do banco de dados
 Remove código redundante

---CORPO do COMMIT
-Escrever e linha ate 75 caracteres e efetuar a quebra de linha
-Adicione detalhes ao commit
-Explique tudo
-Use MARKDOWN


git commit
-este comando ira abrir o editor padrao de texto do git, e permitir que seja editado o conteudo sobre o commit como CORPO, RODAPE e MENSAGEM, caso nao ocorra nenhuma insercao ou alteração e ocorra a saida do editor sem salvar o git ira abortar a criação do commit

git commit -a
-o mesmo que a função anterior, porem a opcao "-a" tem o mesmo papel que o comando "git add *", que se refere a colocar o conteudo na AREA2= STAGED/INDEX para que assim passem a fezer parte do commit

A estrutura de commit coloca-se:
******************
ASSUNTO
---pula uma linha
CORPO
---pula uma linha
RODAPE
******************

EX:
******************
Adiciona mensagem sobre o commit
---pula uma linha
Esse commit modifica e explica algo, a expressao do rodapé "Closes #1" linca este commit com a "ISSUE" do projeto de numero=1 e o git ira automaticamente lincar com ela e dá-la como encerrada.
---pula uma linha
Closes #1
*********************

-------Comandos

git stash
--coloca toda e qualquer alteração de um repositorio em uma caixa separada, iremos chamar de caixa este
setor onde estarao armazenados os arquivos permitindo tranzitar entre branchs sem levar alterações de arquivos entre elas.



git log --oneline
--Listar os comites de forma simples


git reset --soft
--reverte um commit movendo os arquivos e alterando o seu status da
   AREA3: " commited " para a AREA2: " STAGING/INDEX ", sem deletar nenhum 
   arquivo

git reset --mixed
--este é o reset default no git se nenhuma modalidade for especificada esta sera executada,
   e ele reverte um commit movendo os arquivos e alterando o seu status da
   AREA3: " commited " para a AREA1: " WORKING DIR: "

git reset --hard
--ATENCAO --- esta opção gera perda de codigo
--reverte um commit movendo os arquivos e alterando o seu status da
   AREA3: " commited " deletando todos os arquivos /alteracoes de estados comitadas 

git reset HEAD~1
--este comando reverte na modalidade "--mixed" e move o PONTEIRO do git para um commit anterior

git reset HEAD~2
--este comando reverte na modalidade "--mixed" e move o PONTEIRO do git para 2 commit anteriores

git revert HEAD~1
--ira fazer a alteracao reverca a feita pelo commit em questao referenciado, ex: se um arquivo foi criado
pelo commit o revert ira deleta-lo, se uma linha de codigo foi adicionada o revert ira remove-la


--------------
git config --global core.editor "code --wait"
-Alterando o editor de texto padrão chamado pelo terminal pela aplicação do GIT, e colocando o VSCODE como editor padrão a ser chamado

git config --global --unset core.editor
-removendo a configuracao setada anteriomente referente ao editor padrão a ser invocado pelo git,
e retornando ao padrão original, onde nada esta setado ele ira chamar um editor padrão de acordo com a instalação do git



```

