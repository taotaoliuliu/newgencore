package com.newgen.core.common;

public class Constant {
	/***
	 * 管理员在后台系统中，session对应的键
	 */
	public static final String AdminSessionKey = "admin";

	public static int MSizePic, SSizePic;

	/**
	 * 后台管理员默认密码
	 */
	public static String defaultPwd="123456";

	/**
	 * 文件存放地址、与文件服务地址
	 */
	public static String imageSavePath;
	public static String imageServerPath;

	public enum FileType {
		/**
		 * 图片
		 */
		IMG(0),
		/**
		 * 视频
		 */
		VIDEO(2),
		/**
		 * 音频
		 */
		RADIO(1),
		/**
		 * 其他
		 */
		OTHER(3);
		private int index;

		private FileType(int index) {
			this.index = index;
		}

		public int getIndex() {
			return this.index;
		}
	}

	public enum livestate {
		/*
		 * 未开始
		 */
		NotStarted(0),
		/*
		 * 正在直播
		 */
		Playing(1),
		/*
		 * 已结束
		 */
		End(2);

		private int type;

		private livestate(int type) {
			this.type = type;
		}

		public int getLivestate() {
			return this.type;
		}
	}

	/***
	 * 新闻类型枚举
	 * 
	 * @author yilang
	 * 
	 */
	public enum NewsType {
		Txt(0), // 图文

		IMG(1), // 图片

		VIDEO(2), // 视频

		AUDIO(3), // 音频

		VOTE(4), // 投票

		ALL(5), // 综合
		
		Contribute(7),// 投稿(爆料)

		Livetheme(8), // 直播主题

		Livecontent(9); // 直播内容


		private int type;

		private NewsType(int type) {
			this.type = type;
		}

		public int getNewsType() {
			return this.type;
		}
	}

	/**
	 * 系统反馈信息
	 * 
	 * @author yilang
	 * 
	 */
	public enum MsgType {
		LOGINOUT("登录超时", -1), PARAMSEEROR("参数异常", 0), SUCCESS("操作成功", 200), FAIL(
				"操作失败", 400), SYSTEMFAULT("系统繁忙", 500);

		private String msg;// 错误信息
		private int code;// 错误代码

		private MsgType(String msg, int code) {
			this.msg = msg;
			this.code = code;
		}

		public String getMsg() {
			return this.msg;
		}

		public int getCode() {
			return this.code;
		}
	}

	public class TableName {
		public static final String TAB_Member = "t_member";
		public static final String TAB_Role = "t_role";
		public static final String TAB_PowerRole = "t_power_role";
		public static final String TAB_RoleMenu = "t_rolemenu";
		public static final String TAB_Admin = "t_admin";
		public static final String TAB_Category = "t_category";
		public static final String TAB_Department = "t_department";
		public static final String TAB_Log = "t_log";
		public static final String TAB_News = "t_news";
		public static final String TAB_News_Category = "t_news_category";
		public static final String TAB_News_Ext = "t_news_ext";
		public static final String TAB_News_Files = "t_news_files";
		public static final String TAB_News_Personal = "t_news_personal";
		public static final String TAB_News_Review = "t_news_review";
		public static final String TAB_News_Support = "t_news_support";
		public static final String TAB_News_Transfer = "t_news_transfer";
		public static final String TAB_News_Vote = "t_news_vote";
		public static final String TAB_News_Vote_Item = "t_news_vote_item";
		public static final String TAB_Power = "t_power";
		public static final String TAB_Regist_Temp = "t_regist_temp";
		public static final String TAB_User_Department = "t_user_department";
		public static final String TAB_RunImage = "t_runimage";
		public static final String TAB_NewsArea = "t_news_area";
		public static final String TAB_News_Vote_Question = "t_news_vote_question";
		public static final String TAB_WaterMark = "t_watermark";
		public static final String TAB_AppLog = "t_applog";
		public static final String TAB_LiveHost = "t_livehost";
	}

	/**
	 * 日志文件中保存的操作名称
	 */
	public class LobMsg {
		public static final String newsPersonal_save = "个人稿库-新建";
		public static final String newsPersonal_post = "个人稿库-提交";
		public static final String newsPersonal_transfer = "个人稿库-传递";
		public static final String newsPersonal_delete = "个人稿库-删除";
		public static final String newsPersonal_update = "个人稿库-修改";

		public static final String newsTransfer_publish = "公共稿库-发布";
		public static final String newsTransfer_public_relationshipSubject = "公共稿库-发布-关联专题";
		public static final String newsTransfer_transfer = "公共稿库-传稿";
		public static final String newsTransfer_delete = "公共稿库-删搞";

		public static final String newsPublish_reback = "已发稿库-撤稿";
		public static final String newsPublish_top = "已发稿库-置顶";
		public static final String newsPublish_unTop = "已发稿库-取消置顶";

		public static final String newsVote_addVote = "投票管理-添加投票";
		public static final String newsVote_updateVote = "投票管理-更新投票";
		public static final String newsVote_relate = "投票管理-关联新闻";
		public static final String newsVote_delete = "投票管理-删除投票";
		
		public static final String liveManager_addLive = "直播管理-添加直播";
		public static final String liveManager_updateLive = "直播管理-更新直播";
		public static final String liveManager_delete = "直播管理-删除直播";
		
		public static final String liveHostManager_addLiveHost = "直播主持人-添加直播主持人";
		public static final String liveHostManager_updateLiveHost = "直播主持人-更新直播主持人";
		public static final String liveHostManager_deleteLiveHost = "直播主持人-删除直播主持人";
	}

	/****
	 * 错误信息
	 * 
	 * @author yilang
	 * 
	 */
	public class ErrorMsg {
		public static final String usercode_is_empty = "用户名不能为空";
		public static final String password_is_empty = "登陆密码不能为空";
		public static final String not_this_usercode = "此用户不存在";
		public static final String password_error = "密码错误";
	}

	/**
	 * 置顶的时间单位， 天 | 时 | 分
	 * 
	 * @author yilang
	 * 
	 */
	public enum TopDateUnit {
		Day, Hour, Minutes
	}

	public enum NewsTag {
		/**
		 * 普通
		 */
		COMMON(0, "普通"),
		/***
		 * 独家
		 */
		SOLE(1, "原创"),
		/**
		 * 专题
		 */
		SUBJECT(2, "专题 ");

		private int number;
		private String name;

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private NewsTag(int number, String name) {
			this.name = name;
			this.number = number;
		}

		public static NewsTag getByNumber(int i) {
			switch (i) {
			case 0:
				return COMMON;
			case 1:
				return SOLE;
			case 2:
				return SUBJECT;
			default:
				return null;
			}
		}
	}

	/***
	 * 新闻状态
	 * 
	 * @author yilang
	 * 
	 */
	public enum newsState {
		UNPOST(0), POST(1), PUBLIC(2);

		private newsState(int state) {
			this.state = state;
		}

		private int state;

		public int getState() {
			return state;
		}
	}

	/***
	 * 新闻置顶状态
	 * 
	 * @author yilang
	 * 
	 */
	public enum newsTop {
		TOP(1), UNTOP(0);
		private newsTop(int flag) {
			this.flag = flag;
		}

		private int flag;

		public int getFlag() {
			return flag;
		}
	}

	/****
	 * 投票状态
	 * 
	 * @author yilang
	 * 
	 */
	public enum VoteState {
		DEFAULT(0), RUNNING(1), END(2);
		private int flag;

		private VoteState(int flag) {
			this.flag = flag;
		}

		public int getFlag() {
			return this.flag;
		}
	}

	/**
	 * 新闻回复状态
	 * 
	 * @author yilang
	 * 
	 */
	public enum NewsReviewState {
		UNPASS(0), PASS(1), DELETE(2);
		private int state;

		private NewsReviewState(int state) {
			this.state = state;
		}

		public int getState() {
			return state;
		}

	}

	/****
	 * 投票类型
	 * 
	 * @author yilang
	 * 
	 */
	public enum NewsVoteType {
		VOTE(0), // 普通投票
		QUESTION(1);// 问卷调查
		private int type;

		private NewsVoteType(int type) {
			this.type = type;
		}

		public int getType() {
			return this.type;
		}
	}
	/****
	 * 爆料类型
	 * 
	 * @author yilang
	 * 
	 */
	public enum Nexposure {
		NotAudit(0), // 未审核
		Audit(1);// 已审核
		private int type;

		private Nexposure(int type) {
			this.type = type;
		}

		public int getType() {
			return this.type;
		}
	}
	
}
