#language: pt
Funcionalidade: Alterar Simulacoes

  Cenario: Alterar simulacao cadastrada
    Dado que possua um CPF com simulacao realizada
    Quando enviar a requisicao para alterar a simulacao
    Entao o endpoint deve retornar o status 200