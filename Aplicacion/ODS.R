set.seed(1234)

library(igraph)
source("C:\Users\Isra\OneDrive - Universidad Técnica Particular de Loja - UTPL\Documentos\SISTEMAS BASADOS EN CONOCIMIENTO\map.R")

g <-erdos.renyi.game(220, 3/220)
summary(g)

plot(g)
eb <- walktrap.community(g)

membership <- cut_at(eb, no = 10)

plot(g,vertex.color= rainbow(10, .8, .8, alpha=.8)[membership],
     vertex.size=5,  vertex.label=NA,
     edge.arrow.size=.2)