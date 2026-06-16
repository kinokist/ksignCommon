package com.kinokist.ksign.common.handler;

import com.kinokist.ksign.common.service.CryptoService;
import org.apache.ibatis.type.BaseTypeHandler;

import java.sql.*;

public class DecryptTypeHandler extends BaseTypeHandler<String> {
    
    private static CryptoService cryptoService;

    public static void setCryptoService(CryptoService service) {
        cryptoService = service;
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return cryptoService.decrypt(rs.getString(columnName));
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return cryptoService.decrypt(rs.getString(columnIndex));
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cryptoService.decrypt(cs.getString(columnIndex));
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, org.apache.ibatis.type.JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter);
    }
}
