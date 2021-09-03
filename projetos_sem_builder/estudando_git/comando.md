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
```

