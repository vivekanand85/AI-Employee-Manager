package com.javaProject.aipowered.dto;

public class AIResponseDTO {

	private String answer;

	public AIResponseDTO(String answer) {
//		super();
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
