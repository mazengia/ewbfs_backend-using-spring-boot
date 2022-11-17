package com.example.ewbfsbackend.Requests;

import com.example.ewbfsbackend.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.example.ewbfsbackend.util.Util.getNullPropertyNames;

@Service
@AllArgsConstructor
public class RequestsServiceImpl implements RequestsService {

    RequestsRepository requestsRepository;
    RequestsAssembler requestsAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<RequestsDTO> findAll(int page, int size) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<Requests> requests = requestsRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(requests.getContent()))
            return pagedResourcesAssembler.toModel(requests, requestsAssembler);

        return null;
    }

    @Override
    public RequestsDTO addRequests(Requests requests) {
        return requestsAssembler.toModel(requestsRepository.save(requests));
    }

    @Override
    public RequestsDTO findRequestsById(Long id) {
        Requests requests = requestsRepository.findById(id).orElse(null);
        if (requests != null) {
            return requestsAssembler.toModel(requests);
        }
        return null;
    }

    @Override
    public RequestsDTO deleteRequestsById(Long id) {
          requestsRepository.deleteById(id);

        return null;
    }

    @Override
    public RequestsDTO updateRequests(Long id, Requests requests) {
        Requests oldData = requestsRepository.findById(id).orElseThrow(()->new EntityNotFoundException(Requests.class,"Id",String.valueOf(id)));
        if (oldData != null) {
            BeanUtils.copyProperties(requests,oldData,getNullPropertyNames(requests));
            return  addRequests(oldData);
        }
        return null;
    }

    @Override
    public CollectionModel<RequestsDTO> findRequestsByCustomerId(int page, int size, Long id) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<Requests> requests = requestsRepository.findRequestsByCustomersId(pageRequest,id);
        if (!CollectionUtils.isEmpty(requests.getContent()))
            return pagedResourcesAssembler.toModel(requests, requestsAssembler);

        return null;
    }

}
