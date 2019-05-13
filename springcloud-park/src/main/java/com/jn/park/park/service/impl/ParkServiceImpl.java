package com.jn.park.park.service.impl;

import com.jn.park.park.dao.ParkMapper;
import com.jn.park.park.model.ParkGeneral;
import com.jn.park.park.model.ParkName;
import com.jn.park.park.service.ParkService;
import com.jn.park.park.vo.ParkDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkServiceImpl implements ParkService {

    @Autowired
    private ParkMapper mapper;

    /**
     * 园区管理-根据ID获取详情
     */
    @Override
    public ParkDetailsVo getParkdetails(String id) {

        List<ParkDetailsVo> list = mapper.getParkdetails(id);
        ParkDetailsVo garden = new ParkDetailsVo();
        for (ParkDetailsVo nlist : list
        ) {

            String enter = nlist.getIsenter();
            String state = nlist.getParkstate();


            if (enter != null) {

                if (enter.equals("0")) {
                    enter = "未入住";
                }
                if (enter.equals("1")) {
                    enter = "已入住";
                }
                if (enter.equals("2")) {
                    enter = "正在走流程";
                }

                if (state.equals("0")) {
                    state = "未发布";
                }
                if (state.equals("1")) {
                    state = "发布";
                }
                if (state.equals("2")) {
                    state = "失效";
                }

            }

            garden.setIsenter(enter);
            garden.setParkstate(state);
            garden.setCreatedtime(nlist.getCreatedtime());
            garden.setId(nlist.getId());
            garden.setParkname(nlist.getParkname());
            garden.setParkintroduce(nlist.getParkintroduce());
            garden.setCreatoraccount(nlist.getCreatoraccount());
            garden.setMainpicture(nlist.getMainpicture());
            garden.setMinorpicture(nlist.getMinorpicture());

        }
        return garden;
    }

    @Override
    public List<ParkName> getParkName() {
        return mapper.getParkName();
    }


    @Override
    public ParkGeneral getParkGeneral() {
        return mapper.getParkGeneral();
    }
}

