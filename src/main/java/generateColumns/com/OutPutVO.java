package generateColumns.com; 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; 
import io.swagger.annotations.ApiModel; 
import io.swagger.annotations.ApiModelProperty; 
import lombok.Data; 
/** * 
@author wangguangle * * * 
@date 2019/11/26 9:33 
*/ 
@ApiModel(value = "EvQuotationAllCouponListVO", description = "查询所有人的优惠券列表返回实体") 
@JsonIgnoreProperties(ignoreUnknown = true) 
@Data 
public class OutPutVO { 

private static final long serialVersionUID = -8831431585493872787L; 

@ApiModelProperty(value = "注册用户ID") 
private Long userId; 

@ApiModelProperty(value = "用户昵称") 
private String nickName; 

@ApiModelProperty(value = "用户手机") 
private String mobileNumber; 
} 
