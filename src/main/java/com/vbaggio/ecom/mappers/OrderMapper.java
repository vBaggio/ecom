package com.vbaggio.ecom.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.vbaggio.ecom.dto.OrderDTO;
import com.vbaggio.ecom.dto.OrderItemDTO;
import com.vbaggio.ecom.dto.OrderMinDTO;
import com.vbaggio.ecom.dto.PaymentDTO;
import com.vbaggio.ecom.dto.UserMinDTO;
import com.vbaggio.ecom.entitites.Order;
import com.vbaggio.ecom.entitites.OrderItem;
import com.vbaggio.ecom.entitites.Payment;
import com.vbaggio.ecom.entitites.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

	OrderMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(OrderMapper.class);
	
	OrderMinDTO toMinDto(Order order);
	
	OrderDTO toDto(Order order);
	
	default OrderItemDTO toItemDto(OrderItem item) {
		return new OrderItemDTO(
				item.getProduct().getId(),
				item.getProduct().getName(),
				item.getPrice(),
				item.getQuantity(),
				item.getSubtotal()
		);
	}
	
	default PaymentDTO toPaymentDto(Payment payment) {
		return payment == null ? null : new PaymentDTO(payment.getId(), payment.getMoment());
	}
	
	default UserMinDTO toClientDto(User user) {
		return UserMapper.INSTANCE.toMinDto(user);
	}
}
