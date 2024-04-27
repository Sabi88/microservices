package com.tus.organization.dto;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "organization")
@Getter
@Setter
public class OrgContactInfoDto {
	private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}
