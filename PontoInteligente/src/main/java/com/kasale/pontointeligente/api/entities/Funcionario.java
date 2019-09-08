package com.kasale.pontointeligente.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.kasale.pontointeligente.api.enums.PerfilEnum;

/**
 * @author USER
 *
 */
@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable {

	
	private static final long serialVersionUID = 1995097989006937297L;
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private BigDecimal valorHoras;
	private Float qtdeHorasTrabalhoDia;
	private Float qtdeHrasAlmoco;
	private PerfilEnum perfil;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private Empresa empres;
	private List<Lancamento> lancamentos;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="nome", nullable=false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name="email", nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="senha", nullable=false)
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;	
	}
	
	@Column(name="cpf", nullable=false)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Column(name="valor_hora", nullable=false)
	public BigDecimal getValorHoras() {
		return valorHoras;
	}
	
	@Transient
	public Optional<BigDecimal> getValorHoraOpt(){
		return Optional.ofNullable(valorHoras);
	}	
			
	public void setValorHoras(BigDecimal valorHoras) {
		this.valorHoras = valorHoras;
	}
	
	@Column(name="qtd_horas_trabalho_dia", nullable=false)
	public Float getQtdeHorasTrabalhoDia() {
		return qtdeHorasTrabalhoDia;
	}
	
	@Transient
	public Optional<Float> getQtHorasTrabalhoDiaOpt(){
		return Optional.ofNullable(qtdeHorasTrabalhoDia);
	}	
	
	public void setQtdeHorasTrabalhoDia(Float qtdeHorasTrabalhoDia) {
		this.qtdeHorasTrabalhoDia = qtdeHorasTrabalhoDia;
	}
	
	@Column(name="qtd_horas_almoco", nullable=false)
	public Float getQtdeHrasAlmoco() {
		return qtdeHrasAlmoco;
	}
	public void setQtdeHrasAlmoco(Float qtdeHrasAlmoco) {
		this.qtdeHrasAlmoco = qtdeHrasAlmoco;
	}
	
	@Transient
	public Optional<Float> getQtHorasalmocoOpt(){
		return Optional.ofNullable(qtdeHrasAlmoco);
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="perfil", nullable=false)
	public PerfilEnum getPerfil() {
		return perfil;
	}
	
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}
	
	@Column(name="data_criacao", nullable=false)
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@Column(name="data_atualizacao", nullable=false)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Empresa getEmpres() {
		return empres;
	}
	public void setEmpres(Empresa empres) {
		this.empres = empres;
	}
	
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
		
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", valorHoras=" + valorHoras + ", qtdeHorasTrabalhoDia=" + qtdeHorasTrabalhoDia + ", qtdeHrasAlmoco="
				+ qtdeHrasAlmoco + ", perfil=" + perfil + ", dataCriacao=" + dataCriacao + ", dataAtualizacao="
				+ dataAtualizacao + ", empres=" + empres + ", lancamentos=" + lancamentos + "]";
	}
	


	
	
	
}
