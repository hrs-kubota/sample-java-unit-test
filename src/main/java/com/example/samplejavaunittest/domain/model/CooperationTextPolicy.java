package com.example.samplejavaunittest.domain.model;

/**
 * テスト対象なのでリファクタリングはしない。
 */
public class CooperationTextPolicy
{
    private static final String MESSAGE_DOUBLE_BREAK_TAG = "<br> タグは連続使用できません。";
    private static final String MATCH_DOUBLE_BREAK_TAG = "[\\s\\S]*<br>[ \\n\\r\\t]*<br>[\\s\\S]*";

    private static final String MESSAGE_UNAVAILABLE_TAGS = "半角の小なり ( < ) は <b>, <br> タグ以外の用途では使用しないでください。";
    private static final String MATCH_UNAVAILABLE_TAGS = "[\\s\\S]*<((?!b>)(?!\\/b>)(?!br>))[\\s\\S]*";

    private String unavailableTags( String column, String value )
    {
        if ( isEmptyVal( value ) )
            return "";

        if ( value.matches( MATCH_UNAVAILABLE_TAGS ) )
        {
            return String.format( MESSAGE_UNAVAILABLE_TAGS, column );
        }
        return "";
    }

    private String doubleBreakTag( String column, String value )
    {
        if ( isEmptyVal( value ) )
            return "";

        if ( value.matches( MATCH_DOUBLE_BREAK_TAG ) )
        {
            return String.format( MESSAGE_DOUBLE_BREAK_TAG, column );
        }
        return "";
    }

    public boolean isEmptyVal( String val )
    {
        return val == null || val.isEmpty();
    }
}