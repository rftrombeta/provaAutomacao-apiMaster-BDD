#language: pt
Funcionalidade: Remover Simulacoes

  Cenario: Remover simulacao cadastrada
    Dado que possua um CPF com simulacao realizada
    Quando enviar a requisicao para deletar a simulacao
    Entao o endpoint deve retornar o status 200