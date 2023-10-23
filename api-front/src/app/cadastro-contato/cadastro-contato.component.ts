import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Pessoa } from '../model/Pessoa';
import { Contato } from '../model/Contato';

@Component({
  selector: 'app-cadastro-contato',
  templateUrl: './cadastro-contato.component.html',
  styleUrls: ['./cadastro-contato.component.css']
})
export class CadastroContatoComponent {
  pessoa = new Pessoa();
  //contato: Contato = new Contato();
  contatos: Contato[] = [];
  @Input() i!: number;
  @Input() contato: any;
  @Output() remover = new EventEmitter<number>();
  
  adicionarContato() {
    this.pessoa.contatos.push(this.contato);
    this.contato = new Contato();

    //const novoContato = new Contato();
    //this.pessoa.contatos.push(Object.assign({}, novoContato));

    //const novoContato = new Contato();
    //novoContato.nome = this.pessoa.nome;
    //novoContato.telefone = this.pessoa.telefone;
    //novoContato.email = this.pessoa.email;
    //this.pessoa.contatos.push(novoContato);

    // Limpe os campos da pessoa após adicionar o contato, se necessário
    //this.pessoa.nome = '';
    //this.pessoa.telefone = '';
    //this.pessoa.email = '';
  }

  /*removerContato(index: number) {
    this.pessoa.contatos.splice(index, 1);
  }*/

  removerContato(index: number) {
    this.pessoa.contatos.splice(index, 1);
  }
}
