package com.stackroute.musicapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;


import javax.print.DocFlavor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {


    @Id
    private int playerId;


    @NotNull(message = "Enter valid player Name ")
    private String playerName;

    @NotNull(message = "Score cannot be null")
    private int score;


}

