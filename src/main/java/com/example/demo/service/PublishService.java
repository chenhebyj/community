package com.example.demo.service;


import com.example.demo.advice.CustomizeErrorCode;
import com.example.demo.advice.ICustomizeErrorCode;
import com.example.demo.dto.PageInfoDTO;
import com.example.demo.dto.PublishDTO;
import com.example.demo.exception.CustomizeException;
import com.example.demo.mapper.PublishMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Publish;
import com.example.demo.model.PublishExample;
import com.example.demo.model.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublishService {
    @Autowired
    private PublishMapper publishMapper;

    @Autowired
    private UserMapper userMapper;


    public PageInfoDTO selectAll(Integer pageNumber, Integer pageSize) {

        List<PublishDTO> list = new ArrayList<>();
        List<Publish> publishes = new ArrayList<>();
        int count = (int)publishMapper.countByExample(new PublishExample());

        if(pageNumber < 0){
            pageNumber = 1;
        }
        if(pageNumber > count){
            pageNumber = count;
        }
        if(count == 0){
            publishes = publishMapper.selectByExampleWithRowbounds(new PublishExample(),new RowBounds(0, pageSize));
        }else {
            publishes = publishMapper.selectByExampleWithRowbounds(new PublishExample(),new RowBounds((pageNumber - 1) * pageSize, pageSize));
        }

        for (Publish publish :
                publishes) {
            User user = userMapper.selectByPrimaryKey(publish.getCreator());
            PublishDTO publishDTO = new PublishDTO();
            BeanUtils.copyProperties(publish, publishDTO);
            publishDTO.setUser(user);
            list.add(publishDTO);
        }
        PageInfoDTO pageInfoDTO = new PageInfoDTO();
        ArrayList<Integer> integers = new ArrayList<>();
        pageInfoDTO.setPublishDTO(list);
        pageInfoDTO.setPages(integers);
        pageInfoDTO.setInfo(count, pageNumber, pageSize);

        return  pageInfoDTO;
    }

    public PageInfoDTO selectByUserId(User user, Integer pageNumber, Integer pageSize) {

        List<PublishDTO> list = new ArrayList<>();
        PublishExample example = new PublishExample();
        example.createCriteria()
                .andCreatorEqualTo(user.getId());
        int count = (int)publishMapper.countByExample(example);

        if(pageNumber < 0){
            pageNumber = 1;
        }
        if(pageNumber > count){
            pageNumber = count;
        }

        List<Publish> publishes = publishMapper.selectByExampleWithRowbounds(example, new RowBounds((pageNumber - 1) * pageSize, pageSize));
        for (Publish publish :
                publishes) {
            PublishDTO publishDTO = new PublishDTO();
            BeanUtils.copyProperties(publish, publishDTO);
            publishDTO.setUser(user);
            list.add(publishDTO);
        }
        PageInfoDTO pageInfoDTO = new PageInfoDTO();
        ArrayList<Integer> integers = new ArrayList<>();
        pageInfoDTO.setPublishDTO(list);
        pageInfoDTO.setPages(integers);
        pageInfoDTO.setInfo(count, pageNumber, pageSize);



        return pageInfoDTO;
    }

    public PublishDTO selByQuestionId(Integer id) {
        Publish publish = publishMapper.selectByPrimaryKey(id);
        if(publish == null){
            throw new CustomizeException(CustomizeErrorCode.DATA_NOT_FOUND);
        }
        PublishDTO publishDTO = new PublishDTO();
        BeanUtils.copyProperties(publish, publishDTO);
        User user = userMapper.selectByPrimaryKey(publish.getCreator());
        publishDTO.setUser(user);
        return publishDTO;
    }

    public void createOrUpdate(Publish publish) {
        Publish publish1 = publishMapper.selectByPrimaryKey(publish.getId());
        if(publish1 == null){
            //插入
            publish.setGmtCreate(System.currentTimeMillis());
            publish.setGmtModified(publish.getGmtCreate());
            publishMapper.insert(publish);
        }else {
            //更新
            publish.setGmtModified(publish.getGmtCreate());
            PublishExample example = new PublishExample();
            example.createCriteria()
                    .andIdEqualTo(publish.getId());
            int i = publishMapper.updateByExampleSelective(publish, example);
            if(i != 1){
                throw new CustomizeException(CustomizeErrorCode.DATA_NOT_FOUND);
            }
        }

    }
}
