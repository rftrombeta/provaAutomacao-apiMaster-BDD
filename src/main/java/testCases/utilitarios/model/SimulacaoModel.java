package testCases.utilitarios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimulacaoModel {

    private String nome;
    private String cpf;
    private String email;
    private Integer valor;
    private Integer parcelas;
    private boolean seguro;
}
