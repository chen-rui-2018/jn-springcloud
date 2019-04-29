package com.jn.enterprise.pd.declaration.dao;


import com.jn.enterprise.pd.declaration.model.DeclarationPlatformModel;

import java.util.List;

public interface TbPdDeclarationPlatformManageDao {

    List<DeclarationPlatformModel> selectByExample(DeclarationPlatformModel example);

}