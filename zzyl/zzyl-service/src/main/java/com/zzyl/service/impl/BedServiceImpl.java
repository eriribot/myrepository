package com.zzyl.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.zzyl.dto.BedDto;
import com.zzyl.entity.Bed;
import com.zzyl.mapper.BedMapper;
import com.zzyl.service.BedService;
import com.zzyl.utils.ObjectUtil;
import com.zzyl.vo.BedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedMapper bedMapper;

    @Override
    public List<BedVo> getBedsByRoomId(Long roomId) {
        return bedMapper.getBedsByRoomId(roomId);
    }

    @Override
    public void addBed(BedDto bed) {
        Bed bed1 = BeanUtil.toBean(bed, Bed.class);
        bed1.setBedStatus(0);
        bedMapper.addBed(bed1);
    }

    @Override
    public BedVo getBedById(Long id) {
        return BeanUtil.toBean(bedMapper.getBedById(id), BedVo.class);
    }

    @Override
    public void updateBed(BedDto bed) {
        BedVo bedById = getBedById(bed.getId());
        bedById.setSort(bed.getSort());
        bedById.setBedNumber(bed.getBedNumber());
        if (ObjectUtil.isNotEmpty(bed.getBedStatus())) {
            bedById.setBedStatus(bed.getBedStatus());
        }
        Bed bed1 = BeanUtil.toBean(bedById, Bed.class);
        bedMapper.updateBed(bed1);
    }

    @Override
    public void deleteBedById(Long id) {
        bedMapper.deleteBedById(id);
    }

}

