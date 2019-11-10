# language: pt
@skills
Funcionalidade: Venda de produtos para Loja
  Consulta de skills para uma possivel sprint ou projeto
  @testa_skills
    Esquema do Cenario: Gerente consulta uma skill
      Dado Que Gerente cadastra uma skill
      Quando Escolhe a opcao de consultar: <id skill>
      E clica em consultar skill:
      Entao A consulta deve retornar a skill cadastrada: <resultado esperado>
      Exemplos:
          | id skill | resultado esperado                                                                               |
          | "1"      | "Java"      |
          | "2"      | "Python"    |      
          | "3"      | "Docker"    |       
          | "4"      | "C"         |       